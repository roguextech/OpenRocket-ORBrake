package net.sf.openrocket.ORBrake;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import net.sf.openrocket.document.Simulation;
import net.sf.openrocket.gui.SpinnerEditor;
import net.sf.openrocket.gui.adaptors.DoubleModel;
import net.sf.openrocket.gui.components.BasicSlider;
import net.sf.openrocket.gui.components.UnitSelector;
import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.extension.AbstractSwingSimulationExtensionConfigurator;
import net.sf.openrocket.unit.UnitGroup;

@Plugin
public class ORBrakeConfigurator extends AbstractSwingSimulationExtensionConfigurator<ORBrake> {
	
	public ORBrakeConfigurator() {
		super(ORBrake.class);
	}
	
	@Override
	protected JComponent getConfigurationComponent(ORBrake extension, Simulation simulation, JPanel panel) {
		
		panel.add(new JLabel("Setpoint:"));
		DoubleModel S = new DoubleModel(extension, "setpoint", UnitGroup.UNITS_RELATIVE, 0);
		
		JSpinner spinS = new JSpinner(S.getSpinnerModel());
		spinS.setEditor(new SpinnerEditor(spinS));
		panel.add(spinS, "w 65lp!");
		
		UnitSelector unitS = new UnitSelector(S);
		panel.add(unitS, "w 25");
			
		BasicSlider sliderS = new BasicSlider(S.getSliderModel(0, 100));
		panel.add(sliderS, "w 75lp, wrap");
		
		
		panel.add(new JLabel("Proportional Gain:"));
		DoubleModel P = new DoubleModel(extension, "Kp", UnitGroup.UNITS_RELATIVE, 0);
		
		JSpinner spinP = new JSpinner(P.getSpinnerModel());
		spinP.setEditor(new SpinnerEditor(spinP));
		panel.add(spinP, "w 65lp!");
		
		BasicSlider sliderP = new BasicSlider(P.getSliderModel(0, 10));
		panel.add(sliderP, "w 75lp, wrap");
		

		panel.add(new JLabel("Integral Gain:"));
		DoubleModel I = new DoubleModel(extension, "Ki", UnitGroup.UNITS_RELATIVE, 0);
		
		JSpinner spinI = new JSpinner(I.getSpinnerModel());
		spinI.setEditor(new SpinnerEditor(spinI));
		panel.add(spinI, "w 65lp!");
		
		BasicSlider sliderI = new BasicSlider(I.getSliderModel(0, 5));
		panel.add(sliderI, "w 75lp, wrap");

		
		panel.add(new JLabel("Differential Gain:"));
		DoubleModel D = new DoubleModel(extension, "Kd", UnitGroup.UNITS_RELATIVE, 0);
		
		JSpinner spinD = new JSpinner(D.getSpinnerModel());
		spinD.setEditor(new SpinnerEditor(spinD));
		panel.add(spinD, "w 65lp!");
		
		BasicSlider sliderD = new BasicSlider(D.getSliderModel(0, 3));
		panel.add(sliderD, "w 75lp, wrap");
		
		
		return panel;
	}
	
}