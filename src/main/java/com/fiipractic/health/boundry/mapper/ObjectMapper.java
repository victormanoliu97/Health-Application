package com.fiipractic.health.boundry.mapper;

        import com.fiipractic.health.entity.model.Doctor;

public class ObjectMapper {

    public static void map2DoctorDb(Doctor doctorDb, Doctor doctorRequest){
        doctorDb.setDoctorFirstName(doctorRequest.getDoctorFirstName());
        doctorDb.setDoctorLastName(doctorRequest.getDoctorLastName());
        doctorDb.setFunction(doctorRequest.getFunction());
        doctorDb.setAppointmentList(doctorRequest.getAppointmentList());
        doctorDb.setDoctorAdress(doctorRequest.getDoctorAdress());
        doctorDb.setDoctorEmail(doctorRequest.getDoctorEmail());
        doctorDb.setDoctorPhoneNumber(doctorRequest.getDoctorPhoneNumber());
    }
}
