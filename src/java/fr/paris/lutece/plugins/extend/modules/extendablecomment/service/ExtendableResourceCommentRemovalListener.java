package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import fr.paris.lutece.plugins.extend.modules.comment.service.ICommentListener;
import fr.paris.lutece.plugins.extend.modules.extendablecomment.business.ExtendableComment;
import fr.paris.lutece.portal.service.resource.ExtendableResourceRemovalListenerService;
import fr.paris.lutece.portal.service.security.LuteceUser;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;


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
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publishComment( String strIdExtendableResource, boolean bPublished )
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteComment( String strIdExtendableResource, List<Integer> listIdRemovedComment )
    {
        for ( int nIdComment : listIdRemovedComment )
        {
            ExtendableResourceRemovalListenerService.doRemoveResourceExtentions( ExtendableComment.RESOURCE_TYPE,
                    Integer.toString( nIdComment ) );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createComment( String strIdExtendableResource, boolean bPublished, HttpServletRequest request )
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String checkComment( String comment, String uidUser )
    {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String checkComment( String comment, String uidUser, String strResourceType, String strResourceId )
    {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canComment( LuteceUser user, String strIdExtendableResource, String strExtendableResourceType )
    {
        return true;
    }

}
