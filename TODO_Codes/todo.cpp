#include "todo.h"

using namespace std;

Todo::Todo(){
	//create todo list
	//print list
	printList();
}

Todo::~Todo(){
	
}

void Todo::printList(){
	//print list
	if(que[0] != ""){
		for(int i = 0; i < 100; i++){
			if(que[i] != ""){
				cout << i+1 << ": " << que[i] << endl;
			}
		}
	}
	else{
		cout << "Your List is empty" << endl;
	}
}
void Todo::addItem(string item){
	temp = item;
}

void Todo::setPriority(string priority){
	if(priority == "y"){
		push();
	}
	else{
		enque();
	}
}

void Todo::printNext(){
	cout << "~>:Next Item TODO: " << que[0] << endl;
}

void Todo::pop(){
	cout << "->:Compleated " << que[0] << endl;
	for(int i = 1; i < 100; i++){
		que[i-1] = que[i];
	}
}

void Todo::push(){
	string holder = que[0];
	string holder2;
	que[0] = temp; // The first element will have the high priority item...
	temp = "";
	for(int i = 1; i < 100; i++){ // One by one incrementing the index of all or changing the position... 
		holder2 = que[i];
		que[i] = holder;
		holder = holder2;
	}
}

void Todo::enque(){
	for(int i = 0; i < 100; i++){
		if(que[i]==""){
			que[i] = temp;
			temp = "";
		}
	}
}

void Todo::findItem(string item){
	bool found = false;
	int index;
	for(int i = 0; i < 100; i++){
		if(que[i] == item){
			found = true;
			index = i+1;
		}
	}
	if(found){
		cout <<  "~>:Found!" << endl;
		cout << index << ": " << item << endl;
	}
	else{
		cout << "~>:Could not find " << item << endl;
	}
}

void Todo::clear(){
	for(int i = 0; i < 100; i++){
		que[i] = "";
	}
}

void Todo::help(){
	cout << "=====================Commands=====================" << endl;
	cout << "" << endl;
	cout << "" << endl;
	cout << "add		-Adds a new todo item" <<endl;
	cout << "todo		-Shows all items in the todo list" << endl;
	cout << "next		-Shows the next item needed todo" << endl;
	cout << "done		-You have compleated the next item" << endl;
	cout << "find		-Finds if you have that item in your todo list" << endl;
	cout << "" << endl;
	cout << "" << endl;

}
