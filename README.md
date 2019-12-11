# Toyrobot

This excercise requires Java-12 and Junit-4.

com.toyrobot.service.ToyRobotService is the Main serivice class that implements the ToyRobot excercise methods. (place, faceLeft, faceRight, move and report )

com.toyrobot.service.ToyRobotServiceTest is a Junit test class that asserts the acceptance criteria given in the requirement as well as checking some boundary conditions (method testPlaceToyRobotService_AcceptanceTests testing the acceptanceCriteria, method testPlaceToyRobotService_Exception_Conditions_Should_NOT_Alter_Current_State checks the boundary condition making sure any wrong positions are not impacting the current state.

The maximum grid is assumed to be 5 x 5 for this excercise, but changing the constants should allow the code to work for more grids or less grids as appropriate. (through externailzation as well)
  private static final Integer maximumRow = 4;
	private static final Integer maximumColumn = 4;
  
  Given more time, I would add more exception handling and return appropriate user friendly error messages. Also it has been assumed that South/West as the 0,0. It is possible to externalize this to any position allowing user to operate this from any direction.
