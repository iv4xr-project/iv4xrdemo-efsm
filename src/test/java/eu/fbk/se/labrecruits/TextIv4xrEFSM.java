package eu.fbk.se.labrecruits;

import java.util.Set;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.upb.testify.efsm.Configuration;


public class TextIv4xrEFSM {

	private ButtonDoors1 bd1;
	
	  @BeforeEach
	  void setUp() {
		  bd1 = new ButtonDoors1();
	  }
	
	  
	  @Test
	  void canTransitionTest() {
		  
		  
		  // canTransition check if from the current state there exists a feasible transition
		  System.out.println("Testing enable transitions...");
		  
		  // from initial state it is possible to perform a transition with input b_1
		  Assertions.assertTrue(bd1.buttonDoors1EFSM.canTransition("b_1"));		  
		  // from initial state it is possible to perform a transition with empty input
		  Assertions.assertTrue(bd1.buttonDoors1EFSM.canTransition(""));		  		  
		  // from initial state it is not possible to perform a transition with input d_1_p
		  Assertions.assertFalse(bd1.buttonDoors1EFSM.canTransition("d_1_p"));
		  
	  }
	  
	  
	  @Test
	  void freeTravelTest() {
		  
		  System.out.println("Testing free travel transitions...");
		  
		  // from initial state b_0 move to b_1
		  Configuration<LabRecruitsState, LabRecruitsContext> configuration = bd1.buttonDoors1EFSM.transitionAndDrop("b_1");
		  // check if state is correct
		  Assertions.assertEquals(bd1.b_1, configuration.getState());
		  // check that context is not changed
		  Assertions.assertEquals(bd1.buttonDoors1EFSM.getConfiguration().getContext().getDoorStatus("door1"), 
				  configuration.getContext().getDoorStatus("door1"));
		  Assertions.assertEquals(bd1.buttonDoors1EFSM.getConfiguration().getContext().getDoorStatus("door2"), 
				  configuration.getContext().getDoorStatus("door2"));
		  Assertions.assertEquals(bd1.buttonDoors1EFSM.getConfiguration().getContext().getDoorStatus("doorT"), 
				  configuration.getContext().getDoorStatus("doorT"));
	  }
	  
	  @Test 
	  void toogleTest() {
		  
		  System.out.println("Testing toggle transitions...");
		  
		  // door1 should be closed
		  Assertions.assertFalse(bd1.buttonDoors1EFSM.getConfiguration().getContext().getDoorStatus("door1").booleanValue());
		  
		  // from initial state b_0 do a toggle transition, i.e., press button and activate corresponding doors
		  Configuration<LabRecruitsState, LabRecruitsContext> configuration = bd1.buttonDoors1EFSM.transitionAndDrop("");
		  // check if state is correct
		  Assertions.assertEquals(bd1.b_0, configuration.getState());
		  // check if context is correct. Button 0 does not affect doors status
		  Assertions.assertFalse(configuration.getContext().getDoorStatus("door1").booleanValue() );
		  
		  // move to state b_1
		  Configuration<LabRecruitsState, LabRecruitsContext> configuration2 = bd1.buttonDoors1EFSM.transitionAndDrop("b_1");
		  // press button b_1
		  Configuration<LabRecruitsState, LabRecruitsContext> configuration3 = bd1.buttonDoors1EFSM.transitionAndDrop("");
		  // check if door 1 is open
		  Assertions.assertTrue(configuration3.getContext().getDoorStatus("door1").booleanValue() );
	  }
	  
	  
	  @Test
	  void doorStatusTest() {
		  
		  System.out.println("Testing doors status...");
		  
		  Boolean door1_status = bd1.buttonDoors1EFSM.getInitialConfiguration().getContext().getDoorStatus("door1");
		  Assertions.assertFalse(door1_status.booleanValue());		  		 
		  
	  }
	  
	  @Test
	  void testFeasibilityPath() {
		  
		  LabRecruitsFPAlgo fpa = new LabRecruitsFPAlgo(bd1.buttonDoors1EFSM);
		  //Assertions.assertTrue(fpa.pathExists(bd1.TR));
		  
		  
	  }
}
