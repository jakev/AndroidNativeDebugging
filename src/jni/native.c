#include <jni.h>
#include <string.h>
#define START 97

char *generatePassword();


jint Java_com_jakev_debugnative_MainActivity_check( JNIEnv*  env, jobject  this, jstring inputString )
{
	const char *answerString = (*env)->GetStringUTFChars(env, inputString, 0);
	
	char *answer = generatePassword();

	if (strcmp(answer, answerString) == 0) {
		(*env)->ReleaseStringUTFChars(env, inputString, answerString);
		return 1;
	}
 	else {
		(*env)->ReleaseStringUTFChars(env, inputString, answerString);
		return 0;
	}
}

char *generatePassword() {
	
	char *ptr = (char *) malloc(10 * sizeof(char));

	int i = 0;
	for (i; i < 10; i++)
		ptr[i] = (char) (i + START);
		
	ptr[10] = '\0';

	return ptr;

}
