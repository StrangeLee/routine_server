package com.strange.routine_server.controller;

import com.strange.routine_server.entity.Routine;
import com.strange.routine_server.model.response.CommonResult;
import com.strange.routine_server.model.response.ListResult;
import com.strange.routine_server.model.response.SingleResult;
import com.strange.routine_server.repo.RoutineJpaRepo;
import com.strange.routine_server.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. routine"})
@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class RoutineController {

    private final RoutineJpaRepo userJpaRepo;
    private final ResponseService responseService; // 결과를 처리할 Service

    @ApiOperation(value = "루틴 리스트 조회", notes = "모든 루틴을 조회한다.")
    @GetMapping(value = "/routine")
    public ListResult<Routine> findAllRoutine() {

        return responseService.getListResult(userJpaRepo.findAll());
    }

    @ApiOperation(value = "루틴 추가", notes = "새로운 루틴을 추가한다.")
    @PostMapping("/routine")
    public SingleResult<Routine> addRoutine(
            @ApiParam(value = "name", required = true) @RequestParam String name,
            @ApiParam(value = "time", required = true) @RequestParam String time,
            @ApiParam(value = "days", required = true) @RequestParam String days
    ) {
        Routine routine = Routine.builder()
                .name(name)
                .time(time)
                .days(days)
                .build();

        return responseService.getSingleResult(userJpaRepo.save(routine));
    }

    @ApiOperation(value = "루틴 수정", notes = "기존의 루틴을 수정한다.")
    @PutMapping("/routine")
    public SingleResult<Routine> modifyRoutine(
            @ApiParam(value = "routine pk", required = true) @RequestParam Long id,
            @ApiParam(value = "name", required = true) @RequestParam String name,
            @ApiParam(value = "time", required = true) @RequestParam String time,
            @ApiParam(value = "days", required = true) @RequestParam String days
    ) {
        Routine routine = Routine.builder()
                .id(id)
                .name(name)
                .time(time)
                .days(days)
                .build();

        return responseService.getSingleResult(userJpaRepo.save(routine));
    }

    @ApiOperation(value = "루틴 삭제", notes = "routine id로 기존의 루틴을 삭제한다.")
    @DeleteMapping("/routine/{id}")
    public CommonResult deleteRoutine(
            @ApiParam(value = "routine Id", required = true) @PathVariable Long id
    ) {
        userJpaRepo.deleteById(id);

        return responseService.getSuccessResult();
    }

}
