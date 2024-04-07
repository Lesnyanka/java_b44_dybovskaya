package model;


    public record ContactData(String id,
                              String lastname,
                              String firstname,
                              String address,
                              //String address2,
                              String email,
                              String email2,
                              String email3,
                              String mobile,
                              String home,
                              String work,
                              String secondary
    ) {
        public ContactData() {this("", "", "", "", "", "", "", "", "", "", "");
        }



        public model.ContactData withId(String id) {
            return new model.ContactData(id, this.lastname, this.firstname, this.address, this.email, this.email2, this.email3, this.mobile, this.home, this.work, this.secondary);

        }


        public model.ContactData withLastname(String lastname) {
            return new model.ContactData(this.id, lastname, this.firstname, this.address, this.email, this.email2, this.email3, this.mobile, this.home, this.work, this.secondary);

        }

        public model.ContactData withFirstname(String firstname) {
            return new model.ContactData(this.id, this.lastname, firstname, this.address, this.email, this.email2, this.email3, this.mobile, this.home, this.work, this.secondary);

        }

        public model.ContactData withAddress(String address) {
            return new model.ContactData(this.id, this.lastname,this.firstname, address, this.email, this.email2, this.email3, this.mobile, this.home, this.work, this.secondary);

        }

        public model.ContactData withEmail(String email) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, email, this.email2, this.email3, this.mobile, this.home, this.work, this.secondary);
        }

        public model.ContactData withEmail2(String email2) {
            return new model.ContactData(this.id, this.lastname, this.firstname, this.address, this.email, email2, this.email3, this.mobile, this.home, this.work, this.secondary);
        }


        public model.ContactData withEmail3(String email3) {
            return new model.ContactData(this.id, this.lastname, this.firstname, this.address, this.email, this.email2, email3, this.mobile, this.home, this.work, this.secondary);
        }


        public model.ContactData withHome(String home) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.email2, this.email3, this.mobile, home, this.work, this.secondary);

        }

        public model.ContactData withWork(String work) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.email2, this.email3, this.mobile, this.home, work, this.secondary);

        }

        public model.ContactData withSecondary(String secondary) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.email2, this.email3, this.mobile, this.home, this.work, secondary);

        }

        public model.ContactData withMobile(String mobile) {
            return new model.ContactData(this.id, this.lastname,this.firstname, this.address, this.email, this.email2, this.email3,  mobile, this.home, this.work, this.secondary);

            //public model.ContactData withAddress2(String address2) {
                //return new model.ContactData(this.id, this.lastname,this.firstname, this.address, address2, this.email, this.mobile, this.home, this.work, this.secondary);

        }






    }

