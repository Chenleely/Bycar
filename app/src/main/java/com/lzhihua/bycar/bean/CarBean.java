package com.lzhihua.bycar.bean;

import java.io.Serializable;
import java.util.List;

public class CarBean {
    public static class CommonBean {
        private String status;

        public CommonBean() {
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class CommonResponse {
        private String status;

        public CommonResponse() {
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    /*
     * 车辆列表
     * */
    public static class CarList extends CommonBean implements Serializable{
        private CarListData data;

        public CarList() {
        }

        public CarListData getData() {
            return data;
        }

        public void setData(CarListData data) {
            this.data = data;
        }

        public static class CarListData {
            private List<CarListSubData> list;

            public void setList(List<CarListSubData> list) {
                this.list = list;
            }

            public List<CarListSubData> getList() {
                return list;
            }

            public CarListData() {
            }
        }

        public static class CarListSubData implements Serializable {

            private int id;
            private String name;
            private String version;
            private double price;
            private String description;

            public CarListSubData() {
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getId() {
                return id;
            }

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

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }
        }
    }

    /*
     * 创建试驾行程
     * */
    public static class CreateCarRequest {

        private int carId;
        private String address;
        private String phone;

        public CreateCarRequest() {

        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public int getCarId() {
            return carId;
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

    }

    /*
     * 获取试驾行程列表
     * */
    public static class TryCarList extends CommonBean {
        public TryCarList() {
        }

        private Data data;

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
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
        }
    }

    /*
     * 创建试驾行程
     * */
    public static class CreateTrycar {
        private int carId;
        private String address;
        private String phone;

        public CreateTrycar(int carId, String address, String phone) {
            this.carId = carId;
            this.address = address;
            this.phone = phone;
        }

        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class CommonPage {
        private int Limit;
        private int Offset;

        public CommonPage(int limit, int offset) {
            Limit = limit;
            Offset = offset;
        }

        public int getLimit() {
            return Limit;
        }

        public void setLimit(int limit) {
            Limit = limit;
        }

        public int getOffset() {
            return Offset;
        }

        public void setOffset(int offset) {
            Offset = offset;
        }
    }

    public static class IdCommon{
        private int id;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
        public IdCommon(){}
    }
}
