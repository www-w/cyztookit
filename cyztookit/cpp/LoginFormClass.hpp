#include <string>
#include <list>
using namespace std;
class LoginFormClass{
    private:
        string m_name;
        int m_age;
        string m_address;
        string m_phone;
        string m_gender;
        list<string> m_hobbys;
    public:
        void SetName(const char* name){
            m_name=name;
        }
        void SetAge(int age){
            m_age=age;
        }
        void SetAddress(const char* addr){
            m_address=addr;
        }
        void SetPhone(const char* phone){
            m_phone=phone;
        }
        void SetGender(const char* gender){
            m_gender=gender;
        }
        void SetHobby(const char* hobby,bool b){
            string a = hobby;
            list<string>::iterator it = find(m_hobbys.begin(),m_hobbys.end(),a);
            if(b){
                // 标志位置位，若无即增加
                if(it == m_hobbys.end()){
                    m_hobbys.push_back(a);
                }
            }else{
                // 删除某爱好,若有则删除
                if(it!=m_hobbys.end()){
                    m_hobbys.erase(it);
                }
            }
        }
        string GetResult(){
            string a;
            a.append("姓名：").append(m_name).append("\n")
                .append("年龄：").append(to_string(m_age)).append("\n")
                .append("地址：").append(m_address).append("\n")
                .append("电话：").append(m_phone).append("\n")
                .append("性别：").append(m_gender).append("\n")
                .append("爱好：");
            for(auto i : m_hobbys){
                a.append(i).append(" ");
            }

            return a;
        }
};
