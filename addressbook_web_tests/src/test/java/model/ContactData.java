package model;


    public record ContactData(String  lname, String fname, String address, String email, String phone ) {
        public ContactData() {this("", "", "", "", "");
        }


        public model.ContactData withLast_name(String lname) {
            return new model.ContactData(lname, this.fname, this.address, this.email, this.phone);

        }

        public model.ContactData withFirst_name(String fname) {
            return new model.ContactData(this.lname, fname, this.address, this.email, this.phone);

        }

        public model.ContactData withAddress(String address) {
            return new model.ContactData(this.lname, this.fname, address, this.email, this.phone);

        }

        public model.ContactData withEmail(String email) {
            return new model.ContactData(this.lname, this.fname, this.address, email, this.phone);

        }

        public model.ContactData withPhone(String phone) {
            return new model.ContactData(this.lname, this.fname, this.address, this.email, phone);

        }
    }

