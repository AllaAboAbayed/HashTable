package com.company;

import java.util.ArrayList;
import java.util.List;

public class HTChaining extends HashTableBGU {
	
	Function1 hashFunction;
	int size;
	protected Object[] hashTable;
	
	
	public HTChaining(Function hashFunction,int size){
		super(hashFunction, size);
		this.hashFunction = (Function1) hashFunction;
		this.size = size;
		hashTable = getHashTable();
	}
	
	

	@Override
	public void insert(Object key, Object data) {

		HashObject object = new HashObject(key, data);
		int objectHash = hashFunction.h(object.key);
		List<HashObject> chain;
		
		
		if(hashTable[objectHash] == null){
			
			List<HashObject> newChain = new ArrayList<HashObject>();
			hashTable[objectHash] = newChain;
		}
		chain = (List<HashObject>)hashTable[objectHash];
		chain.add(0,object);
	
	}

	@Override
	public void delete(Object key) {
		int objectHash = hashFunction.h(key);
		List<HashObject> chain;
		chain = (List<HashObject>)hashTable[objectHash];
		if(chain != null){
			
			for(int i=0;i<=chain.size()-1;i++){
			
				if(((HashObject)(chain.get(i))).key.equals(key)){
					chain.remove(i);
					return;
				}
				
			}
		}
        
		
		
		
		
		
	}

	@Override
	public boolean isEmpty() {
		for(int i=0;i<=hashTable.length-1;i++){
			if(hashTable[i] != null) return false;
		}
		return true;
	}

	@Override
	public Object find(Object key) {
		int objectHash = hashFunction.h(key);
		List<HashObject> chain;
		chain = (List<HashObject>)hashTable[objectHash];
		if(chain != null){
			
			for(int i=0;i<=chain.size()-1;i++){
			
				if(((HashObject)(chain.get(i))).key.equals(key)){
					return chain.get(i);
					
				}
				
			}
		}
		return null;
	}
	

	
	
	
}
