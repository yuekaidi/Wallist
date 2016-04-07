package logic;

import java.util.ArrayList;

import common.Constant;
import common.State;
import common.Task;
import common.TaskType;
import common.ViewMode;

public class DeleteTask implements Operation {
	private State state;
	
	public DeleteTask(State state) {
		this.state = state;
	}

	@Override
	public boolean process() {
		try {
			// change position index from 1 base(user input) to zero base
			int positionIndex = state.getPositionIndex();
			int positionIndexLocal = fromOneBaseToZeroBase(positionIndex);
			
			System.out.println(positionIndexLocal);
			if(positionIndexLocal <0){
				throw new IndexOutOfBoundsException();
			}
			
			ViewMode viewMode = state.getViewMode();
			
			if(viewMode == ViewMode.FLOATING){
				boolean isDeleteSuccessful = deletedUnderFloatingMode(positionIndexLocal);
				return isDeleteSuccessful;
			}
			
			if(viewMode == ViewMode.DEADLINE){
				boolean isDeleteSuccessful = deleteUnderDeadlineMode(positionIndexLocal);
				return isDeleteSuccessful;
			}
			
			if(viewMode == ViewMode.ALL){
				boolean isDeleteSuccessful = deleteUnderAllMode(positionIndexLocal);
				return isDeleteSuccessful;
			}
			
			if(viewMode == ViewMode.SEARCH){
				boolean isDeleteSuccessful = deleteUnderSearchMode(positionIndexLocal);
				return isDeleteSuccessful;
			}
			
			if(viewMode == ViewMode.FINISHED){
				boolean isDeleteSuccessful = deleteUnderFinishedMode(positionIndexLocal);
				return isDeleteSuccessful;
			}
			//if above code does not return , means not current model to delete
			state.setDisplayMessage(Constant.MESSAGE_DELETE_IN_WRONG_MODE);
			
			return false;
		} catch (IndexOutOfBoundsException e) {
			//logging
			state.setDisplayMessage(Constant.MESSAGE_INDEX_OUT_OF_BOUND);
			return false;
		}
	}
	
	private boolean deleteUnderFinishedMode(int positionIndexLocal) throws IndexOutOfBoundsException{
		ArrayList<Task> finishedTasks = state.getFinishedTasks();
		
		if(positionIndexLocal >= finishedTasks.size()){
			throw new IndexOutOfBoundsException();
		}

		Task toBeDeleted = finishedTasks.get(positionIndexLocal);
		finishedTasks.remove(toBeDeleted);
		
		return true;
	}
	
	private boolean deleteUnderSearchMode(int positionIndexLocal) throws IndexOutOfBoundsException{
		ArrayList<Task> searchedTasks = state.getSearchResultTasks();
		ArrayList<Task> allTasks = state.getAllTasks();
		
		if(positionIndexLocal >= searchedTasks.size()){
			throw new IndexOutOfBoundsException();
		}

		Task toBeDeleted = searchedTasks.get(positionIndexLocal);
		allTasks.remove(toBeDeleted);
		
		TaskType taskType = toBeDeleted.getTaskType();
		
		if(taskType == TaskType.FLOATING){
			ArrayList<Task> floatingTasks = state.getFloatingTasks();
			floatingTasks.remove(toBeDeleted);
		}
		
		if(taskType == TaskType.DEADLINE){
			ArrayList<Task> deadlineTasks = state.getDeadlineTasks();
			deadlineTasks.remove(toBeDeleted);
		}
		
		return true;
	}
	
	
	private boolean deleteUnderAllMode(int positionIndexLocal) throws IndexOutOfBoundsException{
		ArrayList<Task> allTasks = state.getAllTasks();

		if(positionIndexLocal >= allTasks.size()){
			throw new IndexOutOfBoundsException();
		}

		Task toBeDeleted = allTasks.get(positionIndexLocal);
		allTasks.remove(toBeDeleted);
		
		TaskType taskType = toBeDeleted.getTaskType();
		
		if(taskType == TaskType.FLOATING){
			ArrayList<Task> floatingTasks = state.getFloatingTasks();
			floatingTasks.remove(toBeDeleted);
		}
		
		if(taskType == TaskType.DEADLINE){
			ArrayList<Task> deadlineTasks = state.getDeadlineTasks();
			deadlineTasks.remove(toBeDeleted);
		}
		
		return true;
	}
	
	private boolean deleteUnderDeadlineMode(int positionIndexLocal) throws IndexOutOfBoundsException{
		ArrayList<Task> allTasks = state.getAllTasks();
		ArrayList<Task> deadlineTasks = state.getDeadlineTasks();
		
		if(positionIndexLocal >= deadlineTasks.size()){
			throw new IndexOutOfBoundsException();
		}

		Task toBeDeleted = deadlineTasks.get(positionIndexLocal);
		deadlineTasks.remove(toBeDeleted);
		allTasks.remove(toBeDeleted);
		return true;
	}
	
	private boolean deletedUnderFloatingMode(int positionIndexLocal) throws IndexOutOfBoundsException {
		ArrayList<Task> allTasks = state.getAllTasks();
		ArrayList<Task> floatingTasks = state.getFloatingTasks();
		
		if(positionIndexLocal >= floatingTasks.size()){
			throw new IndexOutOfBoundsException();
		}

		Task toBeDeleted = floatingTasks.get(positionIndexLocal);
		floatingTasks.remove(toBeDeleted);
		allTasks.remove(toBeDeleted);
		return true;
	}
	
	private int fromOneBaseToZeroBase(int num) {
		int newNum = num - 1;
		return newNum;
	}
}
