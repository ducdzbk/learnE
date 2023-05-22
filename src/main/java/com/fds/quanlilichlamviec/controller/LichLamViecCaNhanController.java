package com.fds.quanlilichlamviec.controller;

import com.fds.flex.common.ultility.RestfullUtil;
import com.fds.quanlilichlamviec.action.LichLamViecCaNhanAction;
import com.fds.quanlilichlamviec.dto.req.LichLamViecCaNhanReqDTO;
import com.fds.quanlilichlamviec.dto.resp.BaseRespDTO;
import com.fds.quanlilichlamviec.dto.resp.ExceptionRespDTO;
import com.fds.quanlilichlamviec.dto.resp.LichLamViecCaNhanRespDTO;
import com.fds.quanlilichlamviec.entity.T_Model.LichLamViecCaNhan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author vietdd
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/quanlylichlamviec/lichlamvieccanhan")
@Api(value = "API CURD LichLamViecCaNhan entity")
@Slf4j
public class LichLamViecCaNhanController {
    @Autowired
    private LichLamViecCaNhanAction lichLamViecCaNhanAction;

    //@PreAuthorize("hasPermission('com.fds.flex.core.data.entity.C_Model.LichLamViecCaNhan','UPDATE')")
    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    @ApiOperation(value = "Create LichLamViecCaNhan collection", notes = "Create LichLamViecCaNhan collection", response = LichLamViecCaNhanRespDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = LichLamViecCaNhanRespDTO.class),
            @ApiResponse(code = 400, message = "Bad request error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 404, message = "Not found error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 409, message = "Conflic error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionRespDTO.class)})
    public ResponseEntity<?> addLichLamViecCaNhan(@RequestBody LichLamViecCaNhanReqDTO request) {

        log.debug("Get body create LichLamViecCaNhan: {} ", new JSONObject(request));

        LichLamViecCaNhan lichLamViecCaNhan = lichLamViecCaNhanAction.addLichLamViecCaNhan(request);

        return ResponseEntity.ok(new LichLamViecCaNhanRespDTO(RestfullUtil.RespCode.SUCCESS.getCode(), "success", "success", request, lichLamViecCaNhan));

    }

    //@PreAuthorize("hasPermission('com.fds.flex.core.data.entity.C_Model.LichLamViecCaNhan','UPDATE')")
    @PostMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    @ApiOperation(value = "Update LichLamViecCaNhan entity", notes = "Update LichLamViecCaNhan entity", response = LichLamViecCaNhanRespDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = LichLamViecCaNhanRespDTO.class),
            @ApiResponse(code = 400, message = "Bad request error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 404, message = "Not found error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 409, message = "Conflic error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionRespDTO.class)})
    public ResponseEntity<?> updateLichLamViecCaNhan(@PathVariable(name = "id") String id, @RequestBody LichLamViecCaNhanReqDTO request) {

        log.debug("Get body update LichLamViecCaNhan: {} ", new JSONObject(request));

        LichLamViecCaNhan LichLamViecCaNhan = lichLamViecCaNhanAction.updateLichLamViecCaNhan(id, request);

        return ResponseEntity.ok(new LichLamViecCaNhanRespDTO(RestfullUtil.RespCode.SUCCESS.getCode(), "success", "success", request, LichLamViecCaNhan));

    }

    @GetMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    @ApiOperation(value = "Find LichLamViecCaNhan by Id", notes = "Find LichLamViecCaNhan by Id", response = LichLamViecCaNhanRespDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = LichLamViecCaNhanRespDTO.class),
            @ApiResponse(code = 400, message = "Bad request error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 404, message = "Not found error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionRespDTO.class)})
    public ResponseEntity<?> findLichLamViecCaNhan(@PathVariable(name = "id") String id) {

        log.debug("Find LichLamViecCaNhan: {} ", id);

        LichLamViecCaNhan lichLamViecCaNhan = lichLamViecCaNhanAction.findLichLamViecCaNhan(id);

        return ResponseEntity.ok(new LichLamViecCaNhanRespDTO(RestfullUtil.RespCode.SUCCESS.getCode(), "success", "success", null, lichLamViecCaNhan));

    }

    //@PreAuthorize("hasPermission('com.fds.flex.core.data.entity.C_Model.LichLamViecCaNhan','DELETE')")
    @DeleteMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    @ApiOperation(value = "Delete LichLamViecCaNhan by id", notes = "Delete LichLamViecCaNhan by id", response = LichLamViecCaNhanRespDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = LichLamViecCaNhanRespDTO.class),
            @ApiResponse(code = 400, message = "Bad request error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 404, message = "Not found error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 409, message = "Conflic error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionRespDTO.class)})
    public ResponseEntity<?> deleteLichLamViecCaNhan(@PathVariable(name = "id") String id) {

        log.debug("Delete LichLamViecCaNhan: {} ", id);

        lichLamViecCaNhanAction.deleteLichLamViecCaNhan(id);

        return ResponseEntity.ok(
                new BaseRespDTO<String, String>(RestfullUtil.RespCode.SUCCESS.getCode(), "success", "success", id, "Delete success"));

    }

    //@PreAuthorize("hasPermission('com.fds.flex.core.data.entity.C_Model.LichLamViecCaNhan','READ')")
    @GetMapping(value = "/filter", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_PLAIN_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    @ApiOperation(value = "Filter", notes = "Filter", response = Page.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = Page.class),
            @ApiResponse(code = 400, message = "Bad request error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 404, message = "Not found error", response = ExceptionRespDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ExceptionRespDTO.class)})
    public ResponseEntity<?> filter(@RequestParam(name = "keyword", required = false) String keyword,
                                    @RequestParam(name = "thamChieu_maMuc", required = false) String thamChieu_maMuc,
                                    @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size,
                                    @RequestParam(name = "orderFields", required = false, defaultValue = "MaMuc") String orderFields,
                                    @RequestParam(name = "orderTypes", required = false, defaultValue = "asc") String orderTypes) {

        log.debug("Filter LichLamViecCaNhan: keyword: {}, page:{}, size:{}, orderFields:{}, orderTypes:{}", keyword, page, size,
                orderFields, orderTypes);

        Page<LichLamViecCaNhan> result = lichLamViecCaNhanAction.filter(keyword, page, size, orderFields, orderTypes);

        return ResponseEntity.ok(result);

    }
}
