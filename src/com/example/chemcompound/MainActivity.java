package com.example.chemcompound;

import java.util.ArrayList;
import java.util.List;

import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.layout.StructureDiagramGenerator;
import org.openscience.cdk.renderer.AtomContainerRenderer;
import org.openscience.cdk.renderer.font.AWTFontManager;
import org.openscience.cdk.renderer.generators.BasicAtomGenerator;
import org.openscience.cdk.renderer.generators.BasicBondGenerator;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
//import org.openscience.cdk.Molecule;
//import org.openscience.cdk.layout.StructureDiagramGenerator;
//import org.openscience.cdk.templates.MoleculeFactory;



public class MainActivity extends Activity {

	public void test(){
		int WIDTH = 600;
		int HEIGHT = 600;
		
		
		android.graphics.Canvas c;
		

		// the draw area and the image should be the same size
		//Rectangle drawArea;// = new Rectangle(WIDTH, HEIGHT);
		/*Image image = new BufferedImage(
		  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
		);*/

		IAtomContainer triazole = MoleculeFactory.make123Triazole();
		try{StructureDiagramGenerator sdg = new StructureDiagramGenerator();
		sdg.setMolecule((IAtomContainer) triazole);
		sdg.generateCoordinates();
		triazole = sdg.getMolecule();
			}
		catch (Exception e) {}

		// generators make the image elements
		List generators = new ArrayList();
		generators.add(new BasicSceneGenerator());
		generators.add(new BasicBondGenerator());
		generators.add(new BasicAtomGenerator());

		// the renderer needs to have a toolkit-specific font manager
		AtomContainerRenderer renderer =
		  new AtomContainerRenderer(generators, new AWTFontManager());

		// the call to 'setup' only needs to be done on the first paint
		//renderer.setup(triazole, drawArea);

		// paint the background
	
		// the paint method also needs a toolkit-specific renderer
		//renderer.paint(triazole, new AWTDrawVisitor(g2));

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		test();
		
		
		
		
		
	}
	private class DemoView extends View{
		public DemoView(Context context){
			super(context);
		}

		@Override protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);

			// custom drawing code here
			// remember: y increases from top to bottom
			// x increases from left to right
			int x = 0;
			int y = 0;
			Paint paint = new Paint();
			paint.setStyle(Paint.Style.FILL);

			// make the entire canvas white
			paint.setColor(Color.WHITE);
			canvas.drawPaint(paint);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
