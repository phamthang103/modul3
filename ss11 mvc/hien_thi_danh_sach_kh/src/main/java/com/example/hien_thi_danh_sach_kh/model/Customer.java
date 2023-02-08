package com.example.hien_thi_danh_sach_kh.model;

public class Customer {
        private String name;
        private String birthDay;
        private String address;
        private String urlImg;

        public Customer() {
        }

        public Customer(String name, String birthDay, String address, String urlImg) {
            this.name = name;
            this.birthDay = birthDay;
            this.address = address;
            this.urlImg = urlImg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUrlImg() {
            return urlImg;
        }

        public void setUrlImg(String urlImg) {
            this.urlImg = urlImg;
        }
    }
