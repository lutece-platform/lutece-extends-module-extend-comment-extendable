package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import fr.paris.lutece.plugins.extend.modules.comment.service.ICommentListener;
import fr.paris.lutece.plugins.extend.modules.extendablecomment.business.ExtendableComment;
import fr.paris.lutece.portal.service.resource.ExtendableResourceRemovalListenerService;

import java.util.List;


/**
 * Class to remove extensions of comments when they are removed.
 */
public class ExtendableResourceCommentRemovalListener implements ICommentListener
{

    /**
     * {@inheritDoc}
     */
    @Override
    public void createComment( String strIdExtendableResource, boolean bPublished )
    {
        // We do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publishComment( String strIdExtendableResource, boolean bPublished )
    {
        // We do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteComment( String strIdExtendableResource, List<Integer> listIdRemovedComment )
    {
        // We remove extensions of the removed comment if any
        for ( int nIdComment : listIdRemovedComment )
        {
            ExtendableResourceRemovalListenerService.doRemoveResourceExtentions( ExtendableComment.RESOURCE_TYPE,
                    Integer.toString( nIdComment ) );
        }
    }

}
