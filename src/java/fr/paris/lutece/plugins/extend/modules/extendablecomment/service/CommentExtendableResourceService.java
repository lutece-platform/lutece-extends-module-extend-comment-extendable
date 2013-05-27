package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import fr.paris.lutece.plugins.extend.modules.comment.business.Comment;
import fr.paris.lutece.plugins.extend.modules.comment.service.ICommentService;
import fr.paris.lutece.plugins.extend.modules.extendablecomment.business.ExtendableComment;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.resource.IExtendableResource;

import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;


/**
 * CommentExtendableResourceService
 */
public class CommentExtendableResourceService implements ICommentExtendableResourceService
{
    private static final String MESSAGE_RESOURCE_TYPE_DESCRIPTION = "module.extend.extendablecomment.comment.resourceType";

    @Inject
    private ICommentService _commentService;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInvoked( String strResourceType )
    {
        return ExtendableComment.RESOURCE_TYPE.equals( strResourceType );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExtendableResource getResource( String strIdResource, String strResourceType )
    {
        if ( StringUtils.isNotEmpty( strIdResource ) && StringUtils.isNumeric( strIdResource ) )
        {
            Comment comment = _commentService.findByPrimaryKey( Integer.parseInt( strIdResource ) );
            if ( comment != null )
            {
                ExtendableComment commentRating = new ExtendableComment( );
                commentRating.setCommentedExtendableResourceType( comment.getExtendableResourceType( ) );
                commentRating.setIdCommentedExtendableResource( comment.getIdExtendableResource( ) );
                commentRating.setIdExtendableResource( strIdResource );
                return commentRating;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceType( )
    {
        return ExtendableComment.RESOURCE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceTypeDescription( Locale locale )
    {
        return I18nService.getLocalizedString( MESSAGE_RESOURCE_TYPE_DESCRIPTION, locale );
    }

}
