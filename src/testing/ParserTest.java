//@@autor A0130369H
package testing;

import common.*;
import parser.Parser;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParserTest {
	
	@Test
	public void testCommandAdd(){
		// instantiate State and Parser class for testing
		State state = new State();
		Parser parser = new Parser(state);
		
		//Test Add Float
		state.setUserInput("Add eat lunch");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.FLOATING, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());

		//Test Add Float
		state.setUserInput("Add eat lunch detail: with boyfriend");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(true, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals("with boyfriend", state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.FLOATING, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//Test Add Float
		state.setUserInput("Add eat lunch at:soc");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(true, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals("soc", state.getVenue());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.FLOATING, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//Test Add Deadline
		state.setUserInput("Add eat lunch on: 12/12/12");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		//assertEquals(TimeParser.stringToDate("12/12/12"), state.getEndDate());
		
		//Test Add Deadline
		state.setUserInput("Add eat lunch from: 10/10/10 10:10 to: 12/12/12 12:12");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(true, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(TimeParser.stringToDate("10/10/10 10:10"), state.getStartDate());
		assertEquals(TimeParser.stringToDate("12/12/12 12:12"), state.getEndDate());
		
		//Test Add Deadline
		state.setUserInput("Add eat lunch from: 10/10/10 10:10 to: 12/12/12 12:12 at: TOA PAYOH");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(true, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(true, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals("TOA PAYOH", state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(TimeParser.stringToDate("10/10/10 10:10"), state.getStartDate());
		assertEquals(TimeParser.stringToDate("12/12/12 12:12"), state.getEndDate());		
		
		//Test Add Deadline
		state.setUserInput("Add eat lunch from: 10/10/10 10:10 to: 12/12/12 12:12 at: TOA PAYOH detail: with boyfriend");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(true, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(true, state.getIsVenueChanged());
		assertEquals(true, state.getIsDetailChanged());
		assertEquals("TOA PAYOH", state.getVenue());
		assertEquals("with boyfriend", state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(TimeParser.stringToDate("10/10/10 10:10"), state.getStartDate());
		assertEquals(TimeParser.stringToDate("12/12/12 12:12"), state.getEndDate());
		
		//Test Add Deadline
		state.setUserInput("Add eat lunch from: 10/10/10 10:10 to: 12/12/12 12:12 detail: with boyfriend at: TOA PAYOH ");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(true, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(true, state.getIsVenueChanged());
		assertEquals(true, state.getIsDetailChanged());
		assertEquals("TOA PAYOH", state.getVenue());
		assertEquals("with boyfriend", state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(TimeParser.stringToDate("10/10/10 10:10"), state.getStartDate());
		assertEquals(TimeParser.stringToDate("12/12/12 12:12"), state.getEndDate());

		//Test Add Deadline
		state.setUserInput("Add eat lunch from: 10/10/10 10:10 to: 12/12/12 12:12 detail: with boyfriend");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(true, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(true, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals("with boyfriend", state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(TimeParser.stringToDate("10/10/10 10:10"), state.getStartDate());
		assertEquals(TimeParser.stringToDate("12/12/12 12:12"), state.getEndDate());

		//Test Add Deadline
		state.setUserInput("Add eat lunch from: 10/10/10 10:10 to: 12/12/12 12:12 at: toapayoh");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(true, state.getIsStartDateChanged());
		assertEquals(true, state.getIsEndDateChanged());
		assertEquals(true, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals("toapayoh", state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.DEADLINE, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(TimeParser.stringToDate("10/10/10 10:10"), state.getStartDate());
		assertEquals(TimeParser.stringToDate("12/12/12 12:12"), state.getEndDate());
		
		//Test Add Deadline
		state.setUserInput("Add eat lunch from:  to: 10/10/10 10:10 detail: with boyfriend");
		parser.processInput();
		assertEquals(false, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_DATE_NOT_PARSED, state.getDisplayMessage());
		assertEquals(CommandType.ADD, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(true, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals("with boyfriend", state.getDetail());
		//assertEquals("eat lunch", state.getContent());
		assertEquals(TaskType.FLOATING, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());

	}
	
	@Test
	public void testCommandOthers(){
		// instantiate State and Parser class for testing
		State state = new State();
		Parser parser = new Parser(state);
		
		//TEST CLEAR
		state.setUserInput("clear");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.CLEAR, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//TEST delete
		state.setUserInput("delete 3");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.DELETE, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(3, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//TEST tick
		state.setUserInput("tick 3");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.TICK, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(3, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//TEST tick
		state.setUserInput("redo");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.REDO, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//TEST tick
		state.setUserInput("undo");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.UNDO, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		//TEST tick
		state.setUserInput("exit");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.EXIT, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		state.setUserInput("view 1");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.DETAIL, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		
		state.setUserInput("view floating");
		parser.processInput();
		assertEquals(true, state.getIsValid());
		assertEquals(Constant.VALUE_ERROR_NO_ERROR, state.getDisplayMessage());
		assertEquals(CommandType.CHANGEMODE, state.getCommandType());
		assertEquals(false, state.getIsStartDateChanged());
		assertEquals(false, state.getIsEndDateChanged());
		assertEquals(false, state.getIsVenueChanged());
		assertEquals(false, state.getIsDetailChanged());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getVenue());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getDetail());
		assertEquals(Constant.VALUE_DEFAULT_EMPTY, state.getContent());
		assertEquals(TaskType.UNDEFINED, state.getTaskType());
		assertEquals(1, state.getPositionIndex());
		assertEquals(null, state.getStartDate());
		assertEquals(null, state.getEndDate());
		assertEquals(ViewMode.FLOATING, state.getNewViewMode());
	}
}
