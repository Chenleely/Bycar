package com.lzhihua.bycar.bean;

import java.util.List;

public class ManagerBean {
    public static class SaleList {

        private String status;
        private Data data;

        public SaleList() {
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
        }

        public static class Car {
            public Car() {
            }

            private String name;
            private String version;
            private double price;

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getVersion() {
                return version;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getPrice() {
                return price;
            }

        }

        public static class Data {
            public Data() {
            }

            private int limit;
            private int Offset;
            private List<Result> list;

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getLimit() {
                return limit;
            }

            public void setOffset(int Offset) {
                this.Offset = Offset;
            }

            public int getOffset() {
                return Offset;
            }

            public void setList(List<Result> list) {
                this.list = list;
            }

            public List<Result> getList() {
                return list;
            }
        }

        public static class Result {
            public Result() {
            }

            private int id;
            private double price;
            private int status;
            private String address;
            private String createTime;
            private String updateTime;
            private Car car;

            public void setId(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getPrice() {
                return price;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getStatus() {
                return status;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddress() {
                return address;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setCar(Car car) {
                this.car = car;
            }

            public Car getCar() {
                return car;
            }

        }
    }

    public static class OrderIdBean {
        private int orderId;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int id) {
            this.orderId = id;
        }

        public OrderIdBean() {
        }
    }

    public static class AddCar {
        public AddCar() {
        }

        private String name;
        private String version;
        private String price;
        private String description;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getVersion() {
            return version;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPrice() {
            return price;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

    }

    public static class DeleteCar {
        private int carId;

        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public DeleteCar() {
        }
    }

    public static class TrycarList {
        public TrycarList() {
        }

        private String status;
        private Data data;

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
        }

        public static class Car {
            public Car() {
            }

            private String name;
            private String version;
            private double price;

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getVersion() {
                return version;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public double getPrice() {
                return price;
            }
        }

        public static class Result {
            public Result() {
            }

            private int id;
            private String address;
            private String phone;
            private String createTime;
            private String updateTime;
            private Car car;

            public void setId(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddress() {
                return address;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhone() {
                return phone;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setCar(Car car) {
                this.car = car;
            }

            public Car getCar() {
                return car;
            }
        }

        public static class Data {
            public Data() {
            }

            private int limit;
            private int Offset;
            private List<Result> list;

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getLimit() {
                return limit;
            }

            public void setOffset(int Offset) {
                this.Offset = Offset;
            }

            public int getOffset() {
                return Offset;
            }

            public void setList(List<Result> list) {
                this.list = list;
            }

            public List<Result> getList() {
                return list;
            }
        }
    }
}
