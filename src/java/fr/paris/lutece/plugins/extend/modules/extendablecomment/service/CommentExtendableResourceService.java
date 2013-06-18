package fr.paris.lutece.plugins.extend.modules.extendablecomment.service;

import fr.paris.lutece.plugins.extend.modules.comment.business.Comment;
import fr.paris.lutece.plugins.extend.modules.comment.service.CommentPlugin;
import fr.paris.lutece.plugins.extend.modules.comment.service.ICommentService;
import fr.paris.lutece.plugins.extend.modules.comment.util.constants.CommentConstants;
import fr.paris.lutece.plugins.extend.modules.extendablecomment.business.ExtendableComment;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.resource.IExtendableResource;
import fr.paris.lutece.portal.service.util.AppPathService;
import fr.paris.lutece.util.url.UrlItem;

import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;


/**
 * CommentExtendableResourceService
 */
public class CommentExtendableResourceService implements ICommentExtendableResourceService
{
    private static final String MESSAGE_RESOURCE_TYPE_DESCRIPTION = "module.extend.extendablecomment.comment.resourceType";
    private static final String PARAMETER_PAGE = "page";
    private static final String CONSTANT_ANCHOR_COMMENT = "coment_";

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
                ExtendableComment extendableComment = new ExtendableComment( );
                extendableComment.setCommentedExtendableResourceType( comment.getExtendableResourceType( ) );
                extendableComment.setIdCommentedExtendableResource( comment.getIdExtendableResource( ) );
                extendableComment.setIdExtendableResource( strIdResource );
                return extendableComment;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceUrl( String strIdResource, String strResourceType )
    {
        Comment comment = _commentService.findByPrimaryKey( Integer.parseInt( strIdResource ) );
        if ( comment != null )
        {
            UrlItem url = new UrlItem( AppPathService.getPortalUrl( ) );
            url.addParameter( PARAMETER_PAGE, CommentPlugin.PLUGIN_NAME );
            url.addParameter( CommentConstants.PARAMETER_EXTENDABLE_RESOURCE_TYPE, comment.getExtendableResourceType( ) );
            url.addParameter( CommentConstants.PARAMETER_ID_EXTENDABLE_RESOURCE, comment.getIdExtendableResource( ) );
            url.setAnchor( CONSTANT_ANCHOR_COMMENT + strIdResource );
            return url.getUrl( );
        }
        return null;
    }

}
