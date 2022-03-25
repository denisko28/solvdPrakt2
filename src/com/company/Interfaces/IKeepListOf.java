package com.company.Interfaces;

public interface IKeepListOf<TMember> {
    public boolean addListMember(TMember member);

    public boolean removeListMember(TMember member);
}
