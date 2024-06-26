/**
 * Copyright 2013 Nils Assbeck, Guersel Ayaz and Michael Zoech
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.usb.ptp.commands.sony;

import com.example.usb.ptp.NikonCamera;
import com.example.usb.ptp.SonyCamera;
import com.example.usb.ptp.commands.Command;

public abstract class SonyCommand extends Command {

    protected SonyCamera camera;

    public SonyCommand(SonyCamera camera) {
        super(camera);
        this.camera = camera;
    }
}
