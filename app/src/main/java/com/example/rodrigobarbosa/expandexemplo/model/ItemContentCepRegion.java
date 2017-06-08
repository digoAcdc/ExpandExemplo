package com.example.rodrigobarbosa.expandexemplo.model;

/**
 * Created by rodrigobarbosa on 08/06/17.
 */

public class ItemContentCepRegion {
        private long idRegion;
        private long idZone;
        private String descritionContent;
        private boolean checked;

        public long getIdRegion() {
            return idRegion;
        }

        public void setIdRegion(long idRegion) {
            this.idRegion = idRegion;
        }

        public long getIdZone() {
            return idZone;
        }

        public void setIdZone(long idZone) {
            this.idZone = idZone;
        }

        public String getDescritionContent() {
            return descritionContent;
        }

        public void setDescritionContent(String descritionContent) {
            this.descritionContent = descritionContent;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }
}
