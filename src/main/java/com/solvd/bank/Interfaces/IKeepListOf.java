package com.solvd.bank.Interfaces;

public interface IKeepListOf<TMember> {
    public boolean addListMember(TMember member);

    public boolean removeListMember(TMember member);
}
