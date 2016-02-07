# Assignment:

- Design a program using ordinary pipes
- Process 1 sends a string to Process 2
- Process 2 reverses case of each character in the string
- Process 2 sends modified message to Process 1

	Requires two pipes
	  One for sending original message from 1st to 2nd
	  Two for sending modified message from 2nd to 1st

	Can be written with UNIX or WINDOWS

Swap case of file text: "cat filename | tr 'a-zA-Z' 'A-Za-z'"
