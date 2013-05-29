package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import fr.paris.lutece.plugins.extend.modules.comment.service.CommentListenerService;
import fr.paris.lutece.portal.service.plugin.PluginDefaultImplementation;


/**
 * Plugin Comment Rating
 */
public class ExtendableCommentPlugin extends PluginDefaultImplementation
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void init( )
    {
        CommentListenerService.registerListener( CommentListenerService.CONSTANT_EVERY_EXTENDABLE_RESOURCE_TYPE,
                new ExtendableResourceCommentRemovalListener( ) );
    }
}
