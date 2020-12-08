#include "jni.h"
#include <string>
#include "LoginFormClass.hpp"
#define jnifalse 0
LoginFormClass loginFormCls;
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_getResult(
            JNIEnv* env,
            jobject){
    return env->NewStringUTF(loginFormCls.GetResult().c_str());
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_setName(
            JNIEnv* env,
            jobject,
            jstring name){
    const char* cn = env->GetStringUTFChars(name,jnifalse);
    loginFormCls.SetName(cn);
    env->ReleaseStringUTFChars(name,cn);
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_setAge(
            JNIEnv* env,
            jobject,
            jint age){
    loginFormCls.SetAge(age);
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_setAddress(
            JNIEnv* env,
            jobject,
            jstring address) {
    const char* cn = env->GetStringUTFChars(address,jnifalse);
    loginFormCls.SetAddress(cn);
    env->ReleaseStringUTFChars(address,cn);
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_setPhone(
            JNIEnv* env,
            jobject,
            jstring phone){
    const char* cn = env->GetStringUTFChars(phone,jnifalse);
    loginFormCls.SetPhone(cn);
    env->ReleaseStringUTFChars(phone,cn);
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_setGender(
            JNIEnv* env,
            jobject,
            jstring gender){
    const char* cn = env->GetStringUTFChars(gender,jnifalse);
    loginFormCls.SetGender(cn);
    env->ReleaseStringUTFChars(gender,cn);
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_android_helloactivity_LoginFormActivityNative_setHobby(
            JNIEnv* env,
            jobject,
            jstring gender,jboolean b){
    const char* cn = env->GetStringUTFChars(gender,jnifalse);
    loginFormCls.SetHobby(cn,b);
    env->ReleaseStringUTFChars(gender,cn);
}
