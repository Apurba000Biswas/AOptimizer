# AOptimizer

Its a simple andorid library. Helps to manage clean code.

## Using

In the initial version added a General Recycler Adapter 
USING Recycler Adapter:

Step 1:
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
                return "";
        }
    }
}