package uk.ac.ucl.cs.nterreri.GraphicsDemo;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle2D extends Ellipse2D {

	//top-left coordinates of rectangle and diameter of circle (circle is
	//inscribed in the rectangle)
	protected int x, y, diameter;
	protected boolean bouncedH, bouncedV;
	
	/**
	 * Method to check whether the calling circle and some other circle are intersecting each other
	 * 
	 * @param other the other Circle2D relevant for the operation
	 * @return true if the two circles intersect each other in any way, false otherwise
	 * 
	 * @see boolean intersects(int otherX, int otherY, int otherDiameter)
	 */
	protected boolean intersects(Circle2D other) {
		return intersects(other.x, other.y, other.diameter);
	}
	
	/**
	 * Method to check whether the calling circle and some other circle are intersecting each other
	 * 
	 * @param otherX the x coordinate of the top-left corner of the rectangle inscribing the circle
	 * with which the calling circle is to be checked for intersection.
	 * @param otherY the y coordinate of the top-left corner of the rectangle inscribing the circle
	 * with which the calling circle is to be checked for intersection.
	 * @param otherDiameter the diameter of the circle with which the calling circle is to be checked
	 * for intersection.
	 * @return true if the two circles intersect each other in any way, false otherwise
	 * 
	 * @see boolean intersects(Circle2D other)
	 */
	protected boolean intersects(int otherX, int otherY, int otherDiameter) {
		//(x0-x1)^2 +
		if(( Math.pow(((x + (diameter / 2.0))	-	((otherX + (otherDiameter / 2.0)))), 2.0) +
				//(y0-y1)^2
				(	Math.pow(((y + (diameter / 2.0))	-	((otherY + (otherDiameter / 2.0)))), 2.0) )
				//<=(radius0 + radius1)^2
				<=
				Math.pow((diameter/2.0 + otherDiameter/2.0), 2.0)))
			return true;
		else 
			return false;
	}
	
	//left blank
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	//useless
	@Override
	public double getX() {
		return x;
	}
	
	//useless
	@Override
	public double getY() {
		return y;
	}

	//useless
	@Override
	public double getWidth() {
		return diameter;
	}
	
	//useless
	@Override
	public double getHeight() {
		return diameter;
	}

	//left blank
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	//implemented but not used
	@Override
	public void setFrame(double x, double y, double w, double h){
		try {
			setFrame((int) x, (int) y, (int) w, (int) h );
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	//not used
	public void setFrame(int x, int y, int w, int h) throws Exception {
	
		if(w == y)
			this.diameter = w;
		else
			{
				Exception e = new Exception("Cirlce2D instance setFrame \n" +
						"call must set equal width and height parameter\n" +
						"(the rectangle inscribing the circle must be a " +
						"square).");
				throw (e);
			}
		
		if(!(checkPositive(x) && checkPositive(y) && checkPositive(w)))
		{
			Exception e = new Exception("Cricle2D instance setFrame call must" +
					"set positive (or 0) for all parameters.");
			throw e;
		}
		
		this.x = x;
		this.y = y;
	}
	
	//not used
	public void setFrame(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.diameter = d;
	}
	
	//not used
	private boolean checkPositive(int x) {
		if(x < 0)
			return false;
		return true;
	}

}