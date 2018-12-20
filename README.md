# AOptimizer

Its a simple andorid library. Helps to manage clean code.

## Using

In the initial version added a General Recycler Adapter 
USING Recycler Adapter:

Step 1:
Add Dependencies

Add Following line in your "bulid.gradle(Projetc: xxxx)" in "allprojects" block

maven { url 'https://jitpack.io' }

Ex:
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

Add Following line in your "build.gradle(Module: app)" in "dependencies" block

implementation 'com.github.Apurba000Biswas:AOptimizer:1.0.0'

Note: please check recent release version to get update

Step 2:
Implement an Interface that serve as general Data model("DataItem")

Ex:-
public class FamilyMemberModel implements DataItem {
	private String mFirstName;
	private String mLastName;
	private int mAge;

	public FamilyMemberModel(String fistName, String lasteName, int age){
		mFirstName = fistName;
		mLastName = lasteName;
		mAge = age;
	}

	// This method switch the getters
	@Override
    public String switchGetters(int switchGetter) {
        switch (swichGetter){
            case 1:
                return getFirstName();
            case 2:
                return getLastName();
            case 3:
                return "" + getAge();
            default:
                return "Invalid Choice";
        }
    }

    public String getFirstName(){
        return mFirstName;
    }
    public String getLastName(){
        return mLastName;
    }
    public int getAge(){
        return mAge;
    }
}