package com.example.rebonesw.ui.screen.camera

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun CheckpermissionComponent(
    cameraPermission: String = Manifest.permission.CAMERA,
    onPermissionGranted: (Boolean) -> Unit
) {
    val context = LocalContext.current
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            onPermissionGranted(isGranted)
        }
    )

    LaunchedEffect(Unit) {
        // 권한이 이미 부여되었는지 확인
        if (ContextCompat.checkSelfPermission(context, cameraPermission) != PackageManager.PERMISSION_GRANTED) {
            // 권한이 부여되지 않은 경우, 권한 요청
            permissionLauncher.launch(cameraPermission)
        } else {
            // 이미 권한이 부여된 경우
            onPermissionGranted(true)
        }
    }
} //fun CheckpermissionComponent