package com.natetreimer.greenstep.checklist;

import java.util.List;

public class ExtendedChecklistDto {

    private final String requirementString = "requirementString";

    private List<ExtendedChecklist> extendedChecklists;

    public List<ExtendedChecklist> getExtendedChecklists() {
        return extendedChecklists;
    }

    public void setExtendedChecklists(List<ExtendedChecklist> extendedChecklists) {
        this.extendedChecklists = extendedChecklists;
    }
}