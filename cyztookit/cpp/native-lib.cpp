#include <jni.h>
#include <string>
#include <omp.h>
std::string globalString = "sdfa";
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    //std::string hello = "Hello from C++";
    return env->NewStringUTF(globalString.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_TClass_test1(
        JNIEnv* env,
        jobject /* this */) {
    globalString = "test changed";
    return env->NewStringUTF(globalString.c_str());
}
