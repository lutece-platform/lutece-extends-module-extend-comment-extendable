/*
 * Copyright (c) 2002-2026, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.paris.lutece.plugins.extend.modules.extendablecomment.business.ExtendableComment;
import fr.paris.lutece.portal.service.resource.IExtendableResourceService;
import fr.paris.lutece.test.LuteceTestCase;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

/**
 * CommentExtendableResourceService tests.
 */
public class CommentExtendableResourceServiceTest extends LuteceTestCase
{
    @Inject
    private ICommentExtendableResourceService _service;

    /**
     * The service is a CDI bean the core finds among the extendable resource services.
     */
    @Test
    public void isDiscoveredAsExtendableResourceService( )
    {
        assertTrue( CDI.current( ).select( IExtendableResourceService.class ).stream( )
                .anyMatch( s -> ExtendableComment.RESOURCE_TYPE.equals( s.getResourceType( ) ) ), "comment resource service" );
    }

    /**
     * The service only answers for the comment resource type.
     */
    @Test
    public void answersForCommentTypeOnly( )
    {
        assertEquals( ExtendableComment.RESOURCE_TYPE, _service.getResourceType( ), "resource type" );
        assertTrue( _service.isInvoked( ExtendableComment.RESOURCE_TYPE ), "comment type" );
        assertFalse( _service.isInvoked( "document" ), "other type" );
        assertEquals( "Comments", _service.getResourceTypeDescription( Locale.ENGLISH ), "description" );
    }

    /**
     * An empty or non numeric id resolves to no resource.
     */
    @Test
    public void resolvesNoResourceForInvalidId( )
    {
        assertNull( _service.getResource( null, ExtendableComment.RESOURCE_TYPE ), "null id" );
        assertNull( _service.getResource( "", ExtendableComment.RESOURCE_TYPE ), "empty id" );
        assertNull( _service.getResource( "abc", ExtendableComment.RESOURCE_TYPE ), "non numeric id" );
        assertNull( _service.getResourceUrl( null, ExtendableComment.RESOURCE_TYPE ), "null id url" );
        assertNull( _service.getResourceUrl( "abc", ExtendableComment.RESOURCE_TYPE ), "non numeric id url" );
    }
}
