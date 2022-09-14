package com.maveric.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class HeadOffice {

	List<Branch> branches;

	public HeadOffice() {
		branches = new ArrayList<>();
	}

	public Branch createBranch() {
		return new Branch(generateBranchId(), new ArrayList<BankAccount>(), new ArrayList<Customer>());
	}
	
	public String generateBranchId() {
		return branches == null ? "1":Integer.toString(branches.size()+1);
	}

	public Branch getBranchById(String branchId) {
		for (Branch b : branches) {
			if (b.getBranchID().equals(branchId)) {
				return b;
			}
		}
		return null;
	}

	public List<Branch> getAllBranches() {
		return branches;
	}

}
