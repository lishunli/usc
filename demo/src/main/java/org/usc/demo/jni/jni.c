#include "org_usc_demo_jni_HelloNative.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_org_usc_demo_jni_HelloNative_greeting(JNIEnv* env, jclass cl) {
 printf("Hello Native World!\n");
}