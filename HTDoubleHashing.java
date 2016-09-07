package com.company;

public class HTDoubleHashing extends OpenAddressingBGU {
	private Function1 hashFunction;
	private Function2 stepFunction;
	int size;
	protected Object[] hashTable;

	 
	public HTDoubleHashing(Function hashFunction,Function stepFunction, int size) {
		super(hashFunction, size);
		
		this.hashFunction = (Function1) hashFunction;
		this.stepFunction = (Function2)stepFunction;
		this.size = size;
		hashTable = getHashTable();


	}



	@Override
	public void insert(Object key, Object data) {
		HashObject object = new HashObject(key, data);
		int objectHash = hashFunction.h(object.key);
		int j;
		int step = stepFunction.h(object.key);

        for(int i=0;i<=size-1;i++){

			j = objectHash + i*step;

			if(hashTable[j] == null || flags[j]){
				hashTable[j] = object;
				flags[j] = false;
				return;
			}


		}

	}


	@Override
	public void delete(Object key) {

		
		HashObject object = new HashObject(key, null);
		int objectHash = hashFunction.h(object.key);
		int step = stepFunction.h(object.key);       
		int j ;


		for(int i=0;i<=size-1;i++){

			j = objectHash + i*step;
			if(((HashObject)hashTable[j]).key.equals(key)){
				flags[j] = true;
				hashTable[j] = null;
				return;

			}

		}

	}

	@Override
	public boolean isEmpty() {
		int i=0 ;
		
			while(i<size){
				if(hashTable[i] != null && !flags[i])
				return false;
				i++;
			}
			return true;
	}

	@Override
	public Object find(Object key) {
		HashObject object = new HashObject(key, null);
		int objectHash = hashFunction.h(object.key);
		int step = stepFunction.h(object.key);       
		int j;
		

		for(int i=0;i<=size-1;i++){
			j = objectHash +i*step;

			if(((HashObject)hashTable[j]).key.equals(key)){
				return hashTable[j];
			}
			if(hashTable[j] == null && !flags[j])return null;
		}
		return null;

	}

}
