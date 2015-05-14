package com.vspavlov.demoorm.domain.users;

/**
 * Created by Vasiliy on 12.05.2015.
 */
public enum MdbRole {

    VIEWER_USER("Viewer"),
    EDITOR_USER("Editor"),
    ADMIN_USER("Administrator");

    MdbRole(String label) {
      this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static MdbRole fromString(String label) {
        if (label != null) {
            for (MdbRole b : MdbRole.values()) {
                if (label.equalsIgnoreCase(b.label)) {
                    return b;
                }
            }
        }
        return null;
    }

}
