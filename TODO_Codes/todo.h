#ifndef TODO_H // for preventing doublw defining...google it for more
#define TODO_H
#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <fstream>

class Todo{
	public:
		Todo();  // This is the constructor declaration
		~Todo(); // This is the destructor: declaration
		void printList();
		void addItem(std::string item);  // if not using : "using namespace std;", we've to do std:: before using...
		void setPriority(std::string priority);
		void printNext();
		void pop();
		void push();
		void enque();
		void findItem(std::string item);
		void clear();
		void help();
	protected:
	private:
		std::string que[100];
		std::string temp;
};

#endif
