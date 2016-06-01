/*******************************************************************************
 * Copyright (C) 2015 Cyprotex Discovery Ltd - All rights reserved.
 ******************************************************************************/

package crx.converter.spi.blocks;

import java.util.List;

import crx.converter.engine.Part;
import crx.converter.engine.common.DerivativeEvent;
import eu.ddmore.libpharmml.dom.commontypes.CommonVariableDefinition;
import eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLElement;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.commontypes.VariableDefinition;
import eu.ddmore.libpharmml.dom.modeldefn.PopulationParameter;
import eu.ddmore.libpharmml.dom.modeldefn.StructuralModel;
import eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacro;
import eu.ddmore.libpharmml.pkmacro.translation.MacroOutput;

/**
 * Interpreted PharmMl structural block.
 */
public interface StructuralBlock extends Part {
	/**
	 * Check that the structural model has the model element.
	 * @param v
	 * @return boolean
	 */
	public boolean contains(PharmMLRootType v);
	
	/**
	 * Get the dose timing (DT) variable if defined in the model.
	 * @return VariableDefinition
	 */
	public VariableDefinition getDoseTimingVariable();
	
	/**
	 * Get a list of structural model event.
	 * @return java.util.List<StructuralModelEvent>
	 */
	public List<DerivativeEvent> getEvents();

	/**
	 * All of the declared variables in the structural model.
	 * @return List<PharmMLRootType>
	 */
	public List<PharmMLRootType> getListOfDeclarations();
	
	/**
	 * List of local variables
	 * @return java.util.List<eu.ddmore.libpharmml.dom.commontypes.VariableDefinition>
	 */
	public List<VariableDefinition> getLocalVariables();
	
	/**
	 * Get the source structural model.
	 * @return eu.ddmore.libpharmml.dom.modeldefn.StructuralModel
	 */
	public StructuralModel getModel();
	
	/**
	 * Get the list of structural parameters.
	 * @return java.util.List<eu.ddmore.libpharmml.dom.modeldefn.PopulationParameter>
	 */
	public List<PopulationParameter> getParameters();
		
	/**
	 * Get the raw macro outputs generated by the translator component.
	 * @see eu.ddmore.libpharmml.pkmacro.translation.Translator#translate
	 * @return eu.ddmore.libpharmml.pkmacro.translation.MacroOutput
	 */
	public MacroOutput getPKMacroOutput();
	
	/**
	 * Get the source macros of the structural model.
	 * @return List<eu.ddmore.libpharmml.dom.modeldefn.pkmacro.PKMacro>
	 */
	public List<PKMacro> getPKMacros();
	
	/**
	 * Monolix term for equation components that directly reference the independent variable.<br/>
	 * Structural model has time-linked equations.
	 * @return java.util.List<eu.ddmore.libpharmml.dom.commontypes.CommonVariableDefinition>
	 */
	public List<CommonVariableDefinition> getRegressors();
	
	/**
	 * Get the index of a named variable in the state vector passed to a model function.
	 * @param name Variable name
	 * @return java.lang.Integer or -1
	 */
	public Integer getStateVariableIndex(String name);
	
	/**
	 * Get a list of derivatvies
	 * @return java.util.List<eu.ddmore.libpharmml.dom.commontypes.DerivativeVariable>
	 */
	public List<DerivativeVariable> getStateVariables();
	
	@Override
	public List<String> getSymbolIds();
	
	/**
	 * Flag if a dose timing (DT) variable is defined in the model
	 * @return boolean
	 */
	public boolean hasDoseTimingVariable();
	
	/**
	 * Flag that the structural model has simulation events.
	 * @return boolean
	 */
	public boolean hasEvents();
	
	/**
	 * Flag that the structural model has parameters.
	 * @return boolean
	 */
	public boolean hasParameters();
	
	/**
	 * Flag if the structural model has source PK macros.
	 * @return boolean
	 */
	public boolean hasPKMacros();
	
	/**
	 * Flag that the model is a delayed-event ODE.
	 * @return boolean
	 */
	public boolean isDDE();
	
	/**
	 * Flag that the model is an mixed effecgt form.
	 * @return boolean
	 */
	public boolean isMixedEffect();
	
	/**
	 * Flag that model is a standard ODE form.
	 * @return boolean
	 */
	public boolean isODE();
	
	/**
	 * Flag that model is plain function, i.e. no derivatives.
	 * @return boolean
	 */
	public boolean isPlainFunction();
	
	/**
	 * Test if a variable is a regressor, i.e. in a time-linked equation.
	 * @param v Variable
	 * @return boolean
	 */
	public boolean isRegressor(CommonVariableDefinition v);
	
	/**
	 * Test if variable is a derivative.
	 * @param name Variable name
	 * @return boolean
	 */
	public boolean isStateVariable(String name);
	
	/**
	 * Flag if the structural block is using untranslated PK Macros.
	 * @return boolean
	 */
	public boolean isUsingUntranslatedPKMacros();

	/**
	 * Set the ordered variable list within the structural block.<br/>
	 * This is set outside of the StructuralBlock, hence this accessor function.
	 * @param ordered_variables Ordered variable List.
	 */
	public void setOrderedVariableList(List<PharmMLElement> ordered_variables);
	
	/**
	 * Get the raw macro outputs generated by the translator component.
	 * @param macro_output_
	 * @see eu.ddmore.libpharmml.pkmacro.translation.Translator#translate
	 */
	public void setPKMacroOutput(MacroOutput macro_output_);	
	
	/**
	 * Set the PK macro list, as read from a parent structural model.
	 * @param macro_list_ PK Macro list
	 */
	public void setPKMacros(List<PKMacro> macro_list_);
}