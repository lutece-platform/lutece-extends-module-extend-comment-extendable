package fr.paris.lutece.plugins.extend.modules.extendablecomment.business;

import fr.paris.lutece.portal.service.resource.IExtendableResource;

import org.apache.commons.lang.StringUtils;


/**
 * CommentRating
 */
public class ExtendableComment implements IExtendableResource
{
    /**
     * Resource type
     */
    public static final String RESOURCE_TYPE = "comment";

    private String _strIdExtendableResource;
    private String _strCommentedExtendableResourceType;
    private String _strIdCommentedExtendableResource;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIdExtendableResource( )
    {
        return _strIdExtendableResource;
    }

    /**
     * Set the id of this extendable resource
     * @param strIdExtendableResource the id of this extendable resource
     */
    public void setIdExtendableResource( String strIdExtendableResource )
    {
        this._strIdExtendableResource = strIdExtendableResource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExtendableResourceType( )
    {
        return RESOURCE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExtendableResourceName( )
    {
        return StringUtils.EMPTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExtendableResourceDescription( )
    {
        return StringUtils.EMPTY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExtendableResourceImageUrl( )
    {
        return StringUtils.EMPTY;
    }

    /**
     * Get the type of the resource associated with this comment.
     * @return the type of the resource associated with this comment.
     */
    public String getCommentedExtendableResourceType( )
    {
        return _strCommentedExtendableResourceType;
    }

    /**
     * Set the type of the resource associated with this comment.
     * @param strCommentedExtendableResourceType the type of the resource
     *            associated with this comment.
     */
    public void setCommentedExtendableResourceType( String strCommentedExtendableResourceType )
    {
        this._strCommentedExtendableResourceType = strCommentedExtendableResourceType;
    }

    /**
     * Get the id of the resource associated with the comment
     * @return the id of the resource associated with the comment
     */
    public String getCommentedIdExtendableResource( )
    {
        return _strIdCommentedExtendableResource;
    }

    /**
     * Set the id of the resource associated with the comment
     * @param strIdCommentedExtendableResource the id of the resource associated
     *            with the comment
     */
    public void setIdCommentedExtendableResource( String strIdCommentedExtendableResource )
    {
        this._strIdCommentedExtendableResource = strIdCommentedExtendableResource;
    }

}
