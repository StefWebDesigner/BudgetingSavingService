//package com.stefan.BudgetSavingService.service;
//
//import java.util.ArrayList;
//
//public class Temp {
//
//    User findMemId = userRepository.findById(id).orElseThrow(() -> new EntryLogException("User not found"));
//    EntryLog selectedEntry = entryLogRepository.findById(entryId).orElseThrow(() -> new EntryLogException("EntryLog not found"));
//
//    // Create the new ExerciseLog.
//    ExerciseLog newExerciseLog = new ExerciseLog();
//            newExerciseLog.setExerciseName(exerciseLogVO.getExerciseName());
//            newExerciseLog.setEntryId(selectedEntry.getEntryId());  // Assuming this method sets the EntryLog entity and not just an ID.
//            newExerciseLog.setMemberId(findMemId.getMemberId());
//            newExerciseLog.setSets(exerciseLogVO.getSets());
//            newExerciseLog.setReps(exerciseLogVO.getReps());
//            newExerciseLog.setComments(exerciseLogVO.getComments());
//
//    // Link the ExerciseLog to the EntryLog.
//            newExerciseLog.setEntryLog(selectedEntry);  // This is assuming that there's a setEntry() method in ExerciseLog entity.
//
//    // Save the new ExerciseLog to the database.
//            exerciseLogRepository.save(newExerciseLog);
//
//    // If the EntryLog's ExerciseLogList is null, initialize it. Then, add the new ExerciseLog.
//            if(selectedEntry.getExerciseLogList() == null) {
//        selectedEntry.setExerciseLogList(new ArrayList<>());
//    }
//            selectedEntry.getExerciseLogList().add(newExerciseLog);
//
//    // Update the EntryLog in the database.
//            entryLogRepository.save(selectedEntry);
//
//    // Update the user's entry logs.
//            if(findMemId.getEntryLogList() == null) {
//        findMemId.setEntryLogList(new ArrayList<>());
//    }
//            findMemId.getEntryLogList().add(selectedEntry);
//            userRepository.save(findMemId);
//
//            return findMemId;
//}
