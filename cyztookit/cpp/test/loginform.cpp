#include <iostream>
#include "../LoginFormClass.hpp"
using namespace std;
int main(){
    LoginFormClass lfc;
    lfc.SetHobby("abc",1);
    lfc.SetHobby("def",1);
    lfc.SetHobby("ghi",1);
    lfc.SetHobby("def",0);
    cout<<lfc.GetResult()<<endl;
    return 0;
}
