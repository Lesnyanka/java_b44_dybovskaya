package model;


    public record ContactData(String lastname, String firstname, String address, String email, String mobile ) {
        public ContactData() {this("", "", "", "", "");
        }


        public model.ContactData withLastname(String lastname) {
            return new model.ContactData(lastname, this.firstname, this.address, this.email, this.mobile);

        }

        public model.ContactData withFirstname(String firstname) {
            return new model.ContactData(this.lastname, firstname, this.address, this.email, this.mobile);

        }

        public model.ContactData withAddress(String address) {
            return new model.ContactData(this.lastname,this.firstname, address, this.email, this.mobile);

        }

        public model.ContactData withEmail(String email) {
            return new model.ContactData(this.lastname,this.firstname, this.address, email, this.mobile);

        }

        public model.ContactData withMobile(String mobile) {
            return new model.ContactData(this.lastname,this.firstname, this.address, this.email, mobile);

        }
    }

