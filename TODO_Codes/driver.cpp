#include "todo.cpp"
#include <fstream>
#include <iostream>
#include <string>
#include<sstream>

int main(int argc, char *argv[]) { //argv and argc are how command line arguments are passed to main() in C and C++    argc will be the number of strings pointed to by argv. This will (in practice) be 1 plus the number of arguments as 1 will be name of file itself...
	bool quit = false;
	//Main code loop
		std::string input;
		//run startup
		std::cout << "Loading your TODO List..." << std::endl;
		Todo list = Todo();
		//accept input
		while(!quit){
			std::cout << "~>:";
			std::cin >> input;
			std::cin.ignore();	//Get rid of extra newline left in stream after cin
			if(input == "help") {	//choose what to do
				list.help();
			}
			else if(input == "add"){
				std::string item;
				std::string answer;
				std::cout << "~>:What do you have to do?: ";
				std::getline(std::cin, item); // getline() : Extracts characters from is and stores them into str until \n is found
				list.addItem(item);
				std::cout << "~>:Is this important? (y/n): ";
				std::cin >> answer;
				std::cin.ignore();
				list.setPriority(answer);
			}
			else if(input == "todo"){
				list.printList();
			}
			else if(input == "next"){
				list.printNext();
			}
			else if(input == "done"){
				list.pop();
			}
			//made fix to find input. You can now search
			// things with more than one word.
			//Sean Link
			else if(input == "find"){
				std::string item;
				std::cout << "~>:Find: ";
				std::string ws;

				getline(std::cin,item);
				list.findItem(item);
			}
			else{
				std::cout << "Command not found" << std::endl;
				std::cout << "Type 'help' for help on commands" << std::endl;
			}
		}
	return 0;
}
