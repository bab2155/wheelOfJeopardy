package wheelOfJeopardy;

public class CategorySector extends WheelSector
{
	// Instance variables
	String categoryName;

	/**
	 * constructor
	 *
	 * @param theName the name of the category
	 */
	public CategorySector( String theName )
	{
		super( theName );
	}

	/**
	 * set the name of the category
	 *
	 * @param categoryName the name of the category
	 */
	public void setCategory( String categoryName )
	{
		this.categoryName = categoryName;
	}

	/**
	 * return the name of the category
	 *
	 * @return categoryName
	 */
	public String getName( )
	{
		return categoryName;
	}

	@Override
	public void performAction(Controller theController)
	{
		
	}

}
