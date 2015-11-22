package slot.view;

import javax.swing.JFrame;

import slots.Controller.slotController;

public class slotFrame extends JFrame
{
private slotPanel basePanel;
private slotController baseController;

public slotFrame(slotController baseController)
{
	this.baseController = baseController;
	basePanel = new slotPanel(baseController);
	
	setupFrame();
}

private void setupFrame()
{
	this.setContentPane(basePanel);
	this.setSize(500,500);
	this.setVisible(true);
	this.setResizable(false);
	this.setTitle("SLOTS");
	
}

public slotController getBaseController()
{
	return baseController;
}


}
