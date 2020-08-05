package eu.fbk.se.labrecruits;

/**
 * 
 * This class implement feasibility path detection. TODO
 * 
 * @author Davide Prandi
 * 
 */

import java.util.List;

import de.upb.testify.efsm.Configuration;
import de.upb.testify.efsm.EFSM;
import de.upb.testify.efsm.EFSMPath;
import de.upb.testify.efsm.JGraphBasedFPALgo;
import de.upb.testify.efsm.Transition;

public class LabRecruitsFPAlgo extends 
	JGraphBasedFPALgo<LabRecruitsState, String, LabRecruitsContext, Transition<LabRecruitsState,String,LabRecruitsContext>>{

	public LabRecruitsFPAlgo(
			EFSM<LabRecruitsState, String, LabRecruitsContext, Transition<LabRecruitsState, String, LabRecruitsContext>> efsm) {
		super(efsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EFSMPath<LabRecruitsState, String, LabRecruitsContext, Transition<LabRecruitsState, String, LabRecruitsContext>> getPath(
			Configuration<LabRecruitsState, LabRecruitsContext> config, LabRecruitsState tgt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends EFSMPath<LabRecruitsState, String, LabRecruitsContext, Transition<LabRecruitsState, String, LabRecruitsContext>>> getPaths(
			Configuration<LabRecruitsState, LabRecruitsContext> config, LabRecruitsState tgt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pathExists(Configuration<LabRecruitsState, LabRecruitsContext> config, LabRecruitsState tgt) {
		// TODO Auto-generated method stub
		return false;
	}

}
