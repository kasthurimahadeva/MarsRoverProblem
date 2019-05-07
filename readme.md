1. To run the application
- Open terminal or command line and navigate to the demo directory.
- Run ```./gradlew bootJar``` (it is not necessary to have Gradle installed in your system).
- Run ```java -jar mars-rover-problem-1.0-SNAPSHOT.jar ```
- You will see log messages like below
```Rover{id=0, currentPosition=Position{xCoordinate=1, yCoordinate=2, orientation=N}, pathHistory=[], commandSequence=[L, M, L, M, L, M, L, M, M]}
   Rover{id=1, currentPosition=Position{xCoordinate=3, yCoordinate=3, orientation=E}, pathHistory=[], commandSequence=[M, M, R, M, M, R, M, R, R, M]}
   
   R0: starting to move
   R0: initial position - Position{xCoordinate=1, yCoordinate=2, orientation=N}
   R0: command received - L
   R0: after command - Position{xCoordinate=1, yCoordinate=2, orientation=W}
   
   R0: command received - M
   R0: after command - Position{xCoordinate=0, yCoordinate=2, orientation=W}
   
   R0: command received - L
   R0: after command - Position{xCoordinate=0, yCoordinate=2, orientation=S}
   
   R0: command received - M
   R0: after command - Position{xCoordinate=0, yCoordinate=1, orientation=S}
   
   R0: command received - L
   R0: after command - Position{xCoordinate=0, yCoordinate=1, orientation=E}
   
   R0: command received - M
   R0: after command - Position{xCoordinate=1, yCoordinate=1, orientation=E}
   
   R0: command received - L
   R0: after command - Position{xCoordinate=1, yCoordinate=1, orientation=N}
   
   R0: command received - M
   R0: after command - Position{xCoordinate=1, yCoordinate=2, orientation=N}
   
   R0: command received - M
   R0: after command - Position{xCoordinate=1, yCoordinate=3, orientation=N}
   
   
   R1: starting to move
   R1: initial position - Position{xCoordinate=3, yCoordinate=3, orientation=E}
   R1: command received - M
   R1: after command - Position{xCoordinate=4, yCoordinate=3, orientation=E}
   
   R1: command received - M
   R1: after command - Position{xCoordinate=5, yCoordinate=3, orientation=E}
   
   R1: command received - R
   R1: after command - Position{xCoordinate=5, yCoordinate=3, orientation=S}
   
   R1: command received - M
   R1: after command - Position{xCoordinate=5, yCoordinate=2, orientation=S}
   
   R1: command received - M
   R1: after command - Position{xCoordinate=5, yCoordinate=1, orientation=S}
   
   R1: command received - R
   R1: after command - Position{xCoordinate=5, yCoordinate=1, orientation=W}
   
   R1: command received - M
   R1: after command - Position{xCoordinate=4, yCoordinate=1, orientation=W}
   
   R1: command received - R
   R1: after command - Position{xCoordinate=4, yCoordinate=1, orientation=N}
   
   R1: command received - R
   R1: after command - Position{xCoordinate=4, yCoordinate=1, orientation=E}
   
   R1: command received - M
   R1: after command - Position{xCoordinate=5, yCoordinate=1, orientation=E}
   
   
   Rover{id=0, currentPosition=Position{xCoordinate=1, yCoordinate=3, orientation=N}, pathHistory=[Position{xCoordinate=1, yCoordinate=2, orientation=N}, Position{xCoordinate=1, yCoordinate=2, orientation=W}, Position{xCoordinate=0, yCoordinate=2, orientation=W}, Position{xCoordinate=0, yCoordinate=2, orientation=S}, Position{xCoordinate=0, yCoordinate=1, orientation=S}, Position{xCoordinate=0, yCoordinate=1, orientation=E}, Position{xCoordinate=1, yCoordinate=1, orientation=E}, Position{xCoordinate=1, yCoordinate=1, orientation=N}, Position{xCoordinate=1, yCoordinate=2, orientation=N}], commandSequence=[L, M, L, M, L, M, L, M, M]}
   Rover{id=1, currentPosition=Position{xCoordinate=5, yCoordinate=1, orientation=E}, pathHistory=[Position{xCoordinate=3, yCoordinate=3, orientation=E}, Position{xCoordinate=4, yCoordinate=3, orientation=E}, Position{xCoordinate=5, yCoordinate=3, orientation=E}, Position{xCoordinate=5, yCoordinate=3, orientation=S}, Position{xCoordinate=5, yCoordinate=2, orientation=S}, Position{xCoordinate=5, yCoordinate=1, orientation=S}, Position{xCoordinate=5, yCoordinate=1, orientation=W}, Position{xCoordinate=4, yCoordinate=1, orientation=W}, Position{xCoordinate=4, yCoordinate=1, orientation=N}, Position{xCoordinate=4, yCoordinate=1, orientation=E}], commandSequence=[M, M, R, M, M, R, M, R, R, M]}
   
   Successfully wrote output to output.txt
```