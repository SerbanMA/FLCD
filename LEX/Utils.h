#include <map>

#include <algorithm>
#include <iterator>
#include <vector>
#include <iostream>
#include <fstream>
using namespace std;

// - Declaration -
typedef struct {
    int n;
    int elem[400][2];
} PIF;
typedef vector<string> ST;

PIF pif;
ST st;  
int pozST=0;
string error="";

// - Adding -
void addPIF(int code, int posST, PIF& pif) {
    pif.elem[pif.n][0] = code;
    pif.elem[pif.n++][1] = posST;
}

int addST(string symbol, ST& st, PIF& pif) {
    auto it = upper_bound(st.begin(), st.end(), symbol);
	int position=it-st.begin();
	if(position>0 && symbol.compare(st[position-1])==0) {
		return position-1;
	}
	else {
		for(int i=0; i<pif.n; i++)
			if((pif.elem[i][0]==0 || pif.elem[i][0]==1) && pif.elem[i][1]>=position)
				pif.elem[i][1]++;
		st.insert(it,symbol);
		return position;
	}
}

void addError(string text, int line, string message, string& error) {
	error.append("ERROR: ").append(text).append(" at line ").append(to_string(line)).append(" - ").append(message).append("\n\n");
}

// - Printing -
void printPIF(PIF& pif) {
	ofstream pifFile;
    	pifFile.open("PIF.txt");
	pifFile<<"PIF: number of elementss pif "<<pif.n<<endl;
	for(int i=0; i<pif.n; i++){
		pifFile<<pif.elem[i][0]<<"  "<<pif.elem[i][1]<<endl;
	}
	pifFile.close();
}

void printST(vector<string>& st) {
	ofstream stFile;
    	stFile.open("ST.txt");
	stFile<<"SYMBOL TABLE: number of elements ST "<<st.size()<<endl;
	for(int i=0; i<st.size(); i++){
		stFile<<i<<"  "<<st[i]<<endl;
	}
	stFile.close();
}

void printError(string& error) {
	ofstream errorFile;
    	errorFile.open("Errors.txt");
	errorFile<<error;
	errorFile.close();
}