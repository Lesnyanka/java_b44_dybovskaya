package model;


    public record ContactData(String id,
                              String lastname,
                              String firstname,
                              String address,
                              String email,
                              String mobile,
                              String home,
                              String work,
                              String secondary
    ) {
        public ContactData() {this("", "", "", "", "", "", "", "", "");
        }

        public model.ContactData withId(String id) {
            return new model.ContactData(id, this.lastname, this.firstname, this.address, this.email, this.mobile, this.home, this.work, this.secondary);

        }


        public model.ContactData withLastname(String lastname) {
            return new model.ContactData(this.id, lastname, this.firstname, this.address, this.email, this.mobile, this.home, this.work, this.secondary);

        }

        public model.ContactData withFirstname(String firstname) {
            return new model.ContactData(this.id, this.lastname, firstname, this.address, this.email, this.mobile, this.home, this.work, this.secondary);

        }

        public model.ContactData withAddress(String address) {
            return new model.ContactData(this.id, this.lastname,this.firstname, address, this.email, this.mobile, this.home, this.work, this.secondary);

        }

        public model.ContactData withEmail(String email) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, email, this.mobile, this.home, this.work, this.secondary);
        }


        public model.ContactData withHome(String home) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.mobile, home, this.work, this.secondary);

        }

        public model.ContactData withWork(String work) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.mobile, this.home, work, this.secondary);

        }

        public model.ContactData withSecondary(String secondary) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.mobile, this.home, this.work, secondary);

        }

        public model.ContactData withMobile(String mobile) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, mobile, this.home, this.work, this.secondary);

        }



    }

