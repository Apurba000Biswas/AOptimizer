# AOptimizer

Its a simple andorid library. Helps to manage clean code.

## Using

In the initial version added a General Recycler Adapter 
USING Recycler Adapter:

#### Step 1:
Add Dependencies

Add Following line in your "bulid.gradle(Projetc: xxxx)" in "allprojects" block

"maven { url 'https://jitpack.io' }"

Ex:

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

Add Following line in your "build.gradle(Module: app)" in "dependencies" block

"implementation 'com.github.Apurba000Biswas:AOptimizer:1.0.0'"

Note: please check recent release version to get update

#### Step 2:
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

#### Step 3:
Set adapter with RecyclerView

Create an "AR_adapter" adapter object. Which take four parameter

AR_adapter adapter = new AR_adapter(List<DataItem> data
                , R.layout.id
                , Map<Integer, Integer> dataLayoutMap
                , new RecyclerAdapterOnclickListener());

Parameters:
1. "List<DataItem>" - This data gets binded in the recycler view.
2. "Layout resource id" - Single data gets binded through this layout.
3. "Map<Integer, Integer>" - This Map indicate which view should contain the which field value
4. "RecyclerAdapterOnclickListener()" - This object hold the click events(Its an Interface).
	if you dont want to listen click event just pass "null" in this argument.

Ex:
	
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
    	//.....
    	RecyclerView recyclerView = findViewById(R.id.recycler_view);
    	mDataSet = getDataSet();
    	AR_adapter adapter = new AR_adapter(mDataSet
                , R.layout.family_item
                , getDataLayoutMap()
                , new AdapterClickListener());
    	recyclerView.setHasFixedSize(true);
    	recyclerView.setLayoutManager(new LinearLayoutManager(this));
    	recyclerView.setAdapter(adapter);
	}

	private Map<Integer, Integer> getDataLayoutMap(){
        Map<Integer, Integer> dataLayoutMap = new HashMap<Integer, Integer>();
        dataLayoutMap.put(R.id.first_name, 1);
        dataLayoutMap.put(R.id.last_name, 2);
        dataLayoutMap.put(R.id.age, 3);
        return dataLayoutMap;
    }

    private List<DataItem> getDataSet(){
        List<DataItem> dataSet = new ArrayList<DataItem>();
        dataSet.add(new FamilyMemberModel("Apurba", "Biswas", 24));
        //.....
    }

    class AdapterClickListener implements RecyclerAdapterOnclickListener{
        @Override
        public void onClick(View view, int i) {
            // do somthing
        }
    }

# Authors

[Apurba Biswas](https://github.com/Apurba000Biswas)
