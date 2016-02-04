package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import fr.paris.lutece.plugins.extend.modules.comment.service.ICommentListener;
import fr.paris.lutece.plugins.extend.modules.extendablecomment.business.ExtendableComment;
import fr.paris.lutece.portal.service.resource.ExtendableResourceRemovalListenerService;
import fr.paris.lutece.portal.service.security.LuteceUser;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


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

	@Override
	public void createComment(String arg0, boolean arg1, HttpServletRequest arg2) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public String checkComment( String comment, String uidUser )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String checkComment( String comment, String uidUser, String strResourceType, String strResourceId )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canComment( LuteceUser user, String strIdExtendableResource, String strExtendableResourceType )
    {
        return true;
    }

}
